/**
 * Clase AppConfig:
 * 
 * En esta clase se pone las configuraciones,
 * para no cargar la clase principal del programa.
 * 
 *  @author Alejandro Barrionuevo Rosado
 */

package com.alejandro.curso.springboot.app.springboot_crud;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:messages.properties")
public class AppConfig {

}
