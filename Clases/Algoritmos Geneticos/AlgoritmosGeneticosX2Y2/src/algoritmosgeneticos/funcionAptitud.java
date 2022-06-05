/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmosgeneticos;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

/**
 *
 * @author brian
 */
public class funcionAptitud extends FitnessFunction{

    private double fitness; //Variable que llevará el valor de la aptitud
    
    public funcionAptitud(){
        fitness = 0;
    }
    
    @Override
    protected double evaluate(IChromosome cromosoma) {
        Evaluar(cromosoma);
        return fitness; //Agregar comprobación de si es 50
    }
    
    private void Evaluar(IChromosome cromosoma) {
        Integer c1 = (Integer) cromosoma.getGene(0).getAllele();  //Signo X
        Integer c2 = (Integer) cromosoma.getGene(1).getAllele(); 
        Integer c3 = (Integer) cromosoma.getGene(2).getAllele(); 
        Integer c4 = (Integer) cromosoma.getGene(3).getAllele(); 
        Integer c5 = (Integer) cromosoma.getGene(4).getAllele(); 
        Integer c6 = (Integer) cromosoma.getGene(5).getAllele();  //Signo Y 
        Integer c7 = (Integer) cromosoma.getGene(6).getAllele(); 
        Integer c8 = (Integer) cromosoma.getGene(7).getAllele(); 
        Integer c9 = (Integer) cromosoma.getGene(8).getAllele(); 
        Integer c10 = (Integer) cromosoma.getGene(9).getAllele(); 
        
        //Valores de X y Y
        String valorX = c2.toString() + c3.toString() + c4.toString() + c5.toString();
        String valorY = c7.toString() + c8.toString() + c9.toString() + c10.toString();
        
        //Pasar valores a tipo int
        int valorXint = (Integer.parseInt(valorX,2));
        int valorYint = (Integer.parseInt(valorY,2));
        
        if(c1 == 0) {
            valorXint = -valorXint;
        }
        if(c6 == 0) {
            valorYint = -valorYint;
        }
        
        System.out.println(valorXint + " ; " + valorYint);
        
        //fitness = 256 - Math.abs(valor - 50);
        fitness = 450 - ((valorXint)*(valorXint) + valorYint*valorYint);
    }
    
    
}
