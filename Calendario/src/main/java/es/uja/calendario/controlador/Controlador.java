package es.uja.calendario.controlador;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.uja.calendario.dto.TareasDTO;
import es.uja.calendario.dto.UsuarioDTO;
import es.uja.calendario.entidades.Tareas;
import es.uja.calendario.entidades.Usuario;
import es.uja.calendario.excepciones.TareaNoExiste;
import es.uja.calendario.interfaces.ServicioSeguridad;
import es.uja.calendario.interfaces.SistemaTareas;
import es.uja.calendario.utils.LocalDateFormatter;
import es.uja.calendario.utils.LocalDateTimeFormatter;
import es.uja.calendario.utils.MapeadorDTO;

@Controller
public class Controlador {

	@Autowired
	SistemaTareas sistema;

	MapeadorDTO mapeadorDTO;

	@Autowired
	ServicioSeguridad seguridad;

	private static final Logger logger = LoggerFactory.getLogger(Controlador.class);

	@InitBinder
	private void initController(WebDataBinder web) {
		web.addCustomFormatter(new LocalDateTimeFormatter());
		web.addCustomFormatter(new LocalDateFormatter());
	}

	public Controlador() {
		mapeadorDTO = new MapeadorDTO();
	}

	@RequestMapping(value = { "/", "/bienvinido" }, method = RequestMethod.GET)
	public String inicio(Model model,
			@RequestParam(required = false, defaultValue = "2000-01-01T00:00:00") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime desde,
			@RequestParam(required = false, defaultValue = "2050-01-01T00:00:00") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime hasta) {

		model.addAttribute("tareas", sistema.buscaTareas(desde, hasta).stream()
				.map(c -> mapeadorDTO.aCalendarioTareasDTO(c)).collect(Collectors.toList()));
		return "index";
	}

	@RequestMapping(value = "/usuario/crea", method = RequestMethod.GET)
	public String getformusuario(Model model) {
		model.addAttribute("usuario", new Usuario());

		return "crearUsuario";
	}

	@PostMapping("/usuario/crea")
	public String creaCuenta(@ModelAttribute("usuario") @Valid UsuarioDTO uDTO, BindingResult error, ModelMap model,
			RedirectAttributes redir) {
		String url = "";

		mapeadorDTO.sanitizeUsuarioDTO(uDTO);

		if (uDTO.getPassword().equals(uDTO.getPasswordConfirm()) && !error.hasErrors()) {
			sistema.nuevoUsuario(mapeadorDTO.aUsuario(uDTO));
			logger.info("Usuario creado");
			seguridad.autoLogin(uDTO.getUsername(), uDTO.getPassword());
			redir.addFlashAttribute("CuentaCreada", "El cuenta esta creado");
			url = "redirect:/";
		} else {
			model.addAttribute("errorpass", "Datos incorrectos, por favor vuelva a introducirlos");
			url = "crearUsuario";
		}

		return url;
	}

	@RequestMapping(value = "/calendario/crea", method = RequestMethod.GET)
	public String getformCrea(Model model) {
		model.addAttribute("tarea", new TareasDTO());

		return "crearTarea";
	}

	@PostMapping("/calendario/crea")
	public String CreaTarea(@ModelAttribute("tarea") @Valid TareasDTO ctDTO, BindingResult bindingResult, Model model) {

		String view = "";

		if (!bindingResult.hasErrors()) {

			Authentication a = SecurityContextHolder.getContext().getAuthentication();

			sistema.nuevoTarea(mapeadorDTO.aCalendarioTareas(ctDTO, sistema.getUsuario(a.getName())));

			logger.info("Tarea creada");
			view = "redirect:/";
		} else {
			model.addAttribute("errortarea", "Datos incorrectos, por favor vuelva a introducirlos");
			view = "crearTarea";
		}

		return view;
	}

	@GetMapping(path = "/{id}/cancelarTarea")
	public String boraTarea(RedirectAttributes redir, @PathVariable int id) {

		Tareas t = sistema.buscarTareaPorId(id).orElseThrow(TareaNoExiste::new);
		Authentication a = SecurityContextHolder.getContext().getAuthentication();
		if (t.getOrganizador().getUsername().equals(a.getName())) {
			sistema.boraTarea(id);
			redir.addFlashAttribute("borrado", "La tarea esta borrado.");
		} else {
			redir.addFlashAttribute("aBorar", "No puedes eliminar esta tarea porque no esta creado por ti.");
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/{id}/editaTarea", method = RequestMethod.GET)
	public String getformEdita(Model model, RedirectAttributes redir, @PathVariable int id) {
		String v = "";
		Tareas t = sistema.buscarTareaPorId(id).orElseThrow(TareaNoExiste::new);
		Authentication a = SecurityContextHolder.getContext().getAuthentication();
		if (t.getOrganizador().getUsername().equals(a.getName())) {
			model.addAttribute("tarea", mapeadorDTO.aCalendarioTareasDTO(sistema.buscarTareaPorId(id).get()));
			v = "editarTarea";
		} else {
			redir.addFlashAttribute("aEditar", "No puedes editar esta tarea porque no esta creado por ti.");
			v = "redirect:/";
		}
		return v;
	}

	@PostMapping("/{id}/editaTarea")
	public String editaTarea(@ModelAttribute("tarea") @Valid TareasDTO ctDTO, @PathVariable int id,
			BindingResult bindingResult, Model model, RedirectAttributes redir) {

		if (!bindingResult.hasErrors()) {

			Authentication a = SecurityContextHolder.getContext().getAuthentication();
			Tareas t = mapeadorDTO.aCalendarioTareas(ctDTO, sistema.getUsuario(a.getName()));

			if (a.getName().equals(sistema.buscarTareaPorId(id).get().getOrganizador().getUsername())) {
				t.setId(id);
				sistema.actualizaTareas(t);
				logger.info("Tarea Editado");
				redir.addFlashAttribute("editado", "La Tarea esta editado.");
			} else
				redir.addFlashAttribute("aEditar", "No puedes editar esta tarea porque no esta creado por ti.");

		} else {
			redir.addFlashAttribute("error", "Datos incorrectos, por favor vuelva a introducirlos");
		}

		return "redirect:/";
	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "username and password son invalid.");

		return "login";
	}

}
