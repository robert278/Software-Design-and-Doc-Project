using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.Networking; //[Command] [ClientRpc] [SyncVar]
using UnityEngine.UI; //private Text

//THIS IS TERRIBLE CODE -- EACH OF THESE WEIRD FUNCTIONS PROBABLY SHOULD BE IT'S OWN SCRIPT FOR ORGANIZATION PURPOSES
public class basicMovement : NetworkBehaviour { //CHANGE TO NETWORKBEHAVIOUR IF THE SCRIPT SENDS ANY PACKET TO A "CLIENT" OR "SERVER"
	private Vector3 startPosition;

	[SyncVar]
	private int demonstrationVariable = 0;


	//This line opens a 'box' in the editor where the script is attached where you can drag another object in PUBLIC appears in editor, PRIVATE does not
	//If the script is in the 'prefabs' box, the Object must also be a Prefab; if it is in the main scene box, then any Object can usually be dragged in.
	public GameObject networkDemonstration; 

	//private GameObject[] children;

	// Happens before anything, a built in function
	void Start () {
		startPosition = this.transform.position;
		print (this.netId); //The socket to communicate with this, you can store an array of client sockets if you want (netID is a built in thing)
	}
	
	// Update is a built in function that does a safer infinite while loop for you that is
	// called once per computery cycle [Frame/ Tick/ whatever you call it]
	void Update () {
		//GetKey returns true each frame the user presses that key down [Think holding down a key]
		if (Input.GetKey (KeyCode.Space)) { 
			CmdMove ();
		}

		//GetKeyDown returns true each time the key is pressed down 
		if(Input.GetKeyDown(KeyCode.Alpha5)){ //Alpha5 is the 5 key on the row of numbers above
			CmdCount();
		}

		if (this.transform.position.y < -100) {
			this.transform.position = startPosition;
		}
	}

	[Command] //Client to Server
	void CmdMove(){
		this.transform.position += new Vector3 (0, 0, 0.1f);
	}

	[Command]
	void CmdCount(){
		demonstrationVariable++;
		print("5 was pressed " + demonstrationVariable + " times\n");
		//In this case, rather than messaging clients, you would display on the server a physical object like a textbox showing the increased number
		//Actually, here each time a packet is sent to the server from '5' being pressed, the 'floor' will change to black
		/*children = networkDemonstration.GetComponentsInChildren<GameObject>();
		foreach(GameObject child in children){
			if (child.GetComponent<Material> ().color == Color.black) {
				child.GetComponent<Material> ().color = Color.white;
			} else {
				child.GetComponent<Material> ().color = Color.black;
			}
		}*/
		networkDemonstration.transform.position += new Vector3(0.1f, 0, 0);
		//This is moving the PHYSICAL PREFAB which causes all instances of that prefab to move...  

	}

	[ClientRpc] //Server to ALL Clients
	void RpcDoNothing(){
	}

}
