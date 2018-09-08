package com.turnmarker.next.enums;


public enum AvailableList {

	EVERYTHING("All available lists"),
	GAMES_PENDING("Games in play"),
	GAMES_FINISHED("Completed games"),
	GAMES_INPLAY("Games in-progress")
	;
	
	private String description;
	
	AvailableList (String description) {
		
		this.setDescription(description);
				
	}

	/**
	 * @return the description
	 */
	public String getDescription() {

		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {

		this.description = description;
	}
	
}
