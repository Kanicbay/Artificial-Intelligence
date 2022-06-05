/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosgeneticos;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

/**
 *
 * @author brian
 */
public class Prueba {
    
    public void empezar(){
        try {
            //Configuramos JGAP con configuracion por defecto, selección natural por un punto
            Configuration configuration = new DefaultConfiguration();
            //Instancia de nuestra función actitud
            FitnessFunction myFunc = new funcionAptitud();
            //Setear la función actitud en la configuración
            configuration.setFitnessFunction(myFunc); //Le indicamos a JGAP cual sera nuestra función de aptitud
            //Longitud del gen, el conjunto de genes es un arreglo --> esto da igual al cromosoma
            Gene[] genEjemplo = new Gene[10];
            
            //Creamos una codificación de 8 genes que nos servira para nuestros individuos (fenotipo)
            //Los genes seran valores entre 0 y 1 ejemp 01001110 individuo ejemplo
            genEjemplo[0] = new IntegerGene(configuration, 0, 1);
            genEjemplo[1] = new IntegerGene(configuration, 0, 1);
            genEjemplo[2] = new IntegerGene(configuration, 0, 1);
            genEjemplo[3] = new IntegerGene(configuration, 0, 1);
            genEjemplo[4] = new IntegerGene(configuration, 0, 1);
            genEjemplo[5] = new IntegerGene(configuration, 0, 1);
            genEjemplo[6] = new IntegerGene(configuration, 0, 1);
            genEjemplo[7] = new IntegerGene(configuration, 0, 1);
            genEjemplo[8] = new IntegerGene(configuration, 0, 1);
            genEjemplo[9] = new IntegerGene(configuration, 0, 1);
            
            //Recordemos que los cromosomas son el correspondiente a los individuos
            //Creamos un individuo a partir de la configuración de los genes anterior
            Chromosome cromosaNumero = new Chromosome(configuration, genEjemplo);
            //Le indicamos a JGAP un ejemplo de como seran los individuos, a partir del individuo del ejemplo que creamos
            configuration.setSampleChromosome(cromosaNumero);
            configuration.setPopulationSize(5); //Creamos nuestra población inicial
            
            //Creamos el genotipo de la población
            //Recordemos que el genotipo se determina del fenotipo = la configuracipon de los genes para un cromosoma particular
            //Se crea una población de manera aleatoria
            Genotype population = Genotype.randomInitialGenotype(configuration);
            
            //Comienza a iterar el algoritmo
            System.out.println("Población Inicial");
            Mostrar show = new Mostrar();
            for (int m=0; m < 5; m++){ //50 iteraciones, cada iteración será una generación
                System.out.println("------------Inicio generacion--------------");
                System.out.println("Iteracion #" + m);
                show.mostrarTodosIndividuos(population.getChromosomes());
                //Número para ver que tan rapido quieres que tu modelo avance
                //Cada iteración evoluciona 10 veces
                population.evolve(10);
                //show.mostrarTodosIndividuos(population.getChromosomes());
                IChromosome mejor_individuo = population.getFittestChromosome();  //Obtenemos el mejor inidividuo para esta generación
                show.mostrarIndividuo(mejor_individuo);
                System.out.println("Valor de aptitud obtenido: " + mejor_individuo.getFitnessValue());
                System.out.println("-------------Fin generacion----------------");
            }
            
            /*Al final de las iteraciones, obtenemos el mejor individuo,
            * para nuestro ejemplo, es el cuadrado que no repite valores
            * en sus casillas, y cuya suma de líneas verticales, horizontales y
            *diagonales es 15
            */
            System.out.println("Mejor individuo: ");
            show.mostrarIndividuo(population.getFittestChromosome()); //Mejor individuo obtenido
            
        } catch (InvalidConfigurationException ex) {
            Logger.getLogger("No se pudo ejecuta el AG");
        }
        
    }
    
}
