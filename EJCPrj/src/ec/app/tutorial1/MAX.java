package ec.app.tutorial1;

import ec.EvolutionState;
import ec.Individual;
import ec.Problem;
import ec.simple.SimpleFitness;
import ec.simple.SimpleProblemForm;
import ec.vector.BitVectorIndividual;
import ec.vector.FloatVectorIndividual;

public class MAX extends Problem implements SimpleProblemForm {

	@Override
	 public void evaluate(final EvolutionState state,
		        final Individual ind,
		        final int subpopulation,
		        final int threadnum)
		        {
		        if (ind.evaluated) return;

		        if (!(ind instanceof FloatVectorIndividual))
		            state.output.fatal("Whoa!  It's not a BitVectorIndividual!!!",null);
		        
		        int sum=0;
		        float fit=0;
		        FloatVectorIndividual ind2 = (FloatVectorIndividual)ind;
		      
		       
		        for(int x=0; x<ind2.genome.length; x++)
		        	fit+=ind2.genome[x]*ind2.genome[x];
		        fit++;
		           // sum += (ind2.genome[x] ? 1 : 0);
		        
		        if (!(ind2.fitness instanceof SimpleFitness))
		            state.output.fatal("Whoa!  It's not a SimpleFitness!!!",null);
		        ((SimpleFitness)ind2.fitness).setFitness(state,
		            /// ...the fitness...
		            -fit,
		        		//sum/(double)ind2.genome.length,
		            ///... is the individual ideal?  Indicate here...
		            sum == ind2.genome.length);
		        ind2.evaluated = true;
		        }

}
