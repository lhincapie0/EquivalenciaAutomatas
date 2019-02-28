package mundo;

public class Transition {

	private String input;
	private String output;
	private String actualState;
	private String nextState;
	
	public Transition(String input, String output, String actualState, String nextState)
	{
		this.input = input;
		this.output = output;
		this.actualState = actualState;
		this.nextState = nextState;
	}
	
	
	/** Returns the input symbol of the actual state
	 * @return input
	 */
	public String getInput()
	{
		return input;
	}

	
	/** Returns the output symbol of the actual state
	 * @return output
	 */
	public String getOutput() {
		return output;
	}

	
	/** Returns the actual state
	 * @return actual state
	 */
	public String getActualState() {
		return actualState;
	}

	
	/** Returns the next state
	 * @return nextState
	 */
	public String getNextState() {
		return nextState;
	}
}
