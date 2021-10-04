class DessinFractale{
    private final Turtle bob;
    
    private final static int LARGEUR = 800;
    private final static int HAUTEUR = 600;
    //taille de la fenetre graphique

    public DessinFractale(){
	bob  = new Turtle();
	Turtle.setCanvasSize(LARGEUR,HAUTEUR);//à appeler APRES création de la tortue
    }

    public DessinFractale(int v){
	//attention, plus v est grand, plus bob va lentement !
	this();
	bob.speed(v);
    }


    public void reset(){
	bob.clear();
	bob.up();
	bob.setPosition(0,0);
	bob.setDirection(0);
	bob.down();

    }

    public void close(){
	bob.exit();
    }


    public void carre(double l){
	 for (int i=0;i<4;i++){
	 	bob.forward(l);
	 	bob.left(90);
	 }
    }

	public void vonKoch(double l, int n){

    	if(n==0){
    		bob.forward(l);
		}

    	if(n>0) {
			vonKoch(l/3,n-1);
			bob.left(60);
			vonKoch(l/3,n-1);
			bob.right(120);
			vonKoch(l/3,n-1);
			bob.left(60);
			vonKoch(l/3,n-1);
		}
	}

	public void Arbre(double l, int n) {


    	if(n>0){

			bob.forward(l);
			bob.right(30);
			bob.forward(l);
			Arbre(l/3,n-1);

			bob.backward(l);
			bob.left(30);
			bob.forward(l);

			Arbre(l/3,n-1);

			bob.backward(l);
			bob.left(30);
			bob.forward(l);

			Arbre(l/3,n-1);

			bob.backward(l);
			bob.right(30);
			bob.backward(l);


		}
	}

	public void Triforce(double l, int n){

		if(n==0){
			bob.forward(l);
			bob.left(120);
			bob.forward(l);
			bob.left(120);
			bob.forward(l);
			bob.right(240);
		}

    	if(n>0){
				Triforce(l/2,n-1);
				bob.forward(l/2);
				Triforce(l/2,n-1);
				bob.left(120);
				bob.forward(l/2);
				bob.right(120);
				Triforce(l/2,n-1);
				bob.right(120);
				bob.forward(l/2);
				bob.left(120);
		}
	}

	public void DragonAux(double l, int n, int x){
    	if(n<=0){
			bob.forward(l);
		}
    	if(n>0){
    		DragonAux(l,n-1,1);
    		bob.left(90*x);
			DragonAux(l,n-1,-1);
		}
	}
	public  void Dragon(double l, int n){
    	DragonAux(l,n,1);
	}

	public void tour(double l , int n){
    	if(n==0){
    		bob.forward(l);
		}
    	else {
    		bob.left(90);
    		bob.forward(l);
    		bob.right(90);
    		bob.forward(l/4);

    		tour(l/2,n-1);

			bob.forward(l/4);
    		bob.right(90);
			bob.forward(l);
    		bob.left(90);
		}
	}


    public static void main(String[] args){

		DessinFractale d = new DessinFractale(500);
		d.bob.speed(0.0001);
		d.bob.setPosition(-500,0);
		d.bob.clear();
		//d.vonKoch(300,3);
		d.bob.clear();
		//d.Arbre(800,6);
		d.bob.clear();
		//d.Triforce(1800,6);
		d.tour(500000,15);
		Turtle.zoomFit();
    }
    
}