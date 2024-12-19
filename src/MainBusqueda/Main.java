/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MainBusqueda;

import LibreriaBusqueda.ConsultaVotos;


public class Main {
    public static void main(String[] args) {
        // Crear una instancia de ConsultaVotos
        ConsultaVotos consultaVotos = new ConsultaVotos();

        // Realizar algunas consultas de ejemplo
        String resultado1 = consultaVotos.buscarVotos("1", "", "A", "FO");
        System.out.println("Resultado de la búsqueda 1:");
        System.out.println(resultado1);
    }
}
