package com.example.lab6_sol.controller;

import com.example.lab6_sol.entity.Usuario;
import com.example.lab6_sol.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/lista")
    public String listaUsuarios(Model model){
        List<Usuario> estudiantes = usuarioRepository.findByRolid(5);
        model.addAttribute("estudiantes", estudiantes);
        return "lista_usuarios";
    }

    @GetMapping("/edit")
    public String editarEst (@RequestParam("id") Integer id, @ModelAttribute ("usuario") Usuario usuario,Model model){
        Boolean nuevo = false;
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if(usuarioOptional.isPresent()){
            usuario = usuarioOptional.get();
            model.addAttribute("usuario",usuario);
            model.addAttribute("nuevo",nuevo);
            return "formEst";
        }else{
            return "redirect:/estudiante/lista";
        }


    }

    @GetMapping("/new")
    public String nuevoEst (@ModelAttribute ("usuario") Usuario usuario, Model model){
        Boolean nuevo = true;
        model.addAttribute("nuevo",nuevo);
        return "formEst";

    }


    @PostMapping("/save")
    public String guardarEst(@ModelAttribute ("usuario") @Valid Usuario usuario, BindingResult bindingResult, RedirectAttributes attr){

        if(bindingResult.hasErrors()){
            return "formEst";
        }else{
            if(usuario.getId()==0){
                attr.addFlashAttribute("msg", "Usuario creado exitosamente");
            }else{
                attr.addFlashAttribute("msg", "Usuario actualizado exitosamente");
            }
            usuarioRepository.save(usuario);
            return "redirect:/estudiante/lista";
        }


    }


}
