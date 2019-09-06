using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class basicMovement : MonoBehaviour { 
	private Vector3 startPosition;
	private int demonstrationVariable = 0;

	// Happens before anything, a built in function
	void Start () {
		startPosition = this.transform.position;
	}
	
	// Update is a built in function that does a safer infinite while loop
	// called once per computery cycle [Frame/ Tick/ whatever you call it]
	void Update () {
		//GetKey returns true each frame the user presses that key down [Think holding down a key]
		if (Input.GetKey (KeyCode.Space)) { 
			//Adds 0.1 to the Z of the object that has this script attach's position; increase velocity by increasing what this number is
			this.transform.position += new Vector3 (0, 0, 0.1f);
		}

		//GetKeyDown returns true each time the key is pressed down 
		if(Input.GetKeyDown(KeyCode.Alpha5)){ //Alpha5 is the 5 key on the row of numbers above
			demonstrationVariable++;
			print("5 was pressed " + demonstrationVariable + " times\n");
		}

		//If the car falls off, reset it to where it started.
		if (this.transform.position.y < -100) {
			this.transform.position = startPosition;
		}
	}

	//Example of a function
	void DoNothing(){
	}
}
