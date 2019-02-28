package mundo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;




/**
 * Adjacency matrix implementation to represented a machine. Personalized for this special case.
 * @author Laura Hincapié
 */
public class Machine {
	
	private ArrayList<String> setQ;
	private Transition[][] matrix;
	private Set<Transition> transitions;
	private ArrayList<String> setS;
	private ArrayList<String> setR;
	private int no_States;
	
	
	
	/**
	 * Constructs a machine with n states, an input set and an output set 
	 * @param no_Estados, quantity of states of the machine
	 * @param setS, set of input symbols
	 * @param setR, set of output symbols
	 */
	public Machine(int no_States, ArrayList<String> setS, ArrayList<String> setR)
	{
		nameStates(no_States);
		matrix = new Transition[no_States][no_States];
		transitions = new TreeSet<Transition>();
		this.setS = setS;
		this.setR = setR;
	}
	
	/**
	 * Names the states of the machine as "Qi"
	 * @param num, quantity of states of the machine
	 */
	public void nameStates(int num)
	{
		for( int i=0; i<num; i++)
		{
			setQ.add(i, "Q"+i);
		}
	}
	
	/**
	 * Adds a transition to the machine
	 * @param input, input symbol for the actual state
	 * @param output, output symbol of the actual state
	 * @param actualState, actual state
	 * @param nextState, next state
	 */
	public void agregarTransicion(String input, String salida, String actualState, String nextState)
	{
		Transition transition = new Transition(input, salida, actualState, nextState);
		int actual = searchState(actualState);
		int next = searchState(nextState);
		matrix[actual][next] = transition;
		transitions.add(transition);
	}
	
	/**
	 * Searchs the index of the state q in the ArrayList setQ
	 * @param q, name of the state to search
	 * @return a, index of the state in the ArrayList setQ
	 */
	public int searchState(String q)
	{
		int a = -1;
		for(int i = 0; i<setQ.size() && a<0;i++)
		{
			if(setQ.get(i).equals(q))
			{
				a = i;
			}
		}
		return a;	
	}
	
	/**
	 * Search s if there is a transition between two states
	 * @param estadoActual, actual state in the machine
	 * @param estadoLlegada, next state in the machine
	 * @return true, if from actualState to nextState there is a transition
	 * @return false, if from actualState to nextState there is no transition
	 */
	public boolean isTransition(String actualState, String nextState)
	{
		
		int actual = searchState(actualState);
		int next = searchState(nextState);
		if(matrix[actual][next] != null)
		{
			return true;
		}else
			return false;
		
	}
	
	/**
	 * Returns a transition between two states
	 * @param actualState, actual state of the machine
	 * @param nextState, next state in the machine
	 * @return
	 */
	public Transition getTransition(String actualState, String nextState)
	{
		if(isTransition(actualState, nextState))
		{
			int actual = searchState(actualState);
			int next = searchState(nextState);
			return matrix[actual][next];
		}
		else return null;
	}

	
	/**
	 * Returns the states where tha machine can be from a state q1
	 * @param q1, actual state of the machine 
	 * @return adjacencyList of q1
	 */
	public ArrayList<String> getAdjacentsStates(String q1) {

		ArrayList<String> adjacencyList = new ArrayList<String>();
		int actual = searchState(q1);
		for (int i = 0; i < no_States; i++) {
			if(matrix[actual][i]!=null) {
				adjacencyList.add(setQ.get(i));
			}
		}
		return adjacencyList;
	}

	public void deleteState(String q) {
		
		int deletedIndex = searchState(q);
	
		setQ.remove(deletedIndex);
		Transition[][] newMachine = new Transition[no_States-1][no_States-1];
		int col = 0;
		int row = 0;
		boolean done = false;
		for( int i = 0; i<no_States & !done;i++)
		{
			for( int j = 0; j<no_States & !done;j++)
			{
				if(i!= deletedIndex && j != deletedIndex )
				{
					newMachine[row][col] = matrix[i][j]; 
					col++;
					if(col == no_States)
					{
						col = 0;
						row ++;
					}
					if( row == no_States -1)
					{
						done = true;
					}
				}
			}
		}
		matrix = newMachine;
		no_States --;
		
		
	}
	
	/**
	 * Deletes a transition between two states
	 * @param q1 a state, where the transition begins
	 * @param q2 a state, where the transition ends
	 */
	public void deleteTransition(String q1, String q2)
	{
		int state1 = searchState(q1);
		int state2 = searchState(q2);
		Transition deleted = matrix[state1][state2];
		matrix[state1][state2]  = null;
		transitions.remove(deleted);
		
	
		
	}
	

	/**
	 * Returns the transitions that goes out from a state q
	 * @param q, the actual state of the machine
	 * @return an Arraylist with the transitions that goes out from q
	 */
	public ArrayList<Transition> getOutgoingTransition(String q)
	{
		ArrayList<Transition> outgoingTransitions = new ArrayList<Transition>();
		int actual = searchState(q);
		for( int i = 0; i<no_States;i++)
		{
			if(matrix[actual][i] != null)
			{
				outgoingTransitions.add(matrix[actual][i]);
			}
		}
		
		return outgoingTransitions;
	}
	
	

}

	
	


