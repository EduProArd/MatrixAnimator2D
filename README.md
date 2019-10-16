## MatrixAnimator2D
This java application written using Swing framework let you create bidimensional matrices animations.

### How does it work?
Everything revolves around the idea of manipulating the animation through JavaScript code.
You can interact with Java classes through JavaScript code thanks to Nashorn engine.

### How to use?
You should create a file called _animation.js_ in the same folder where you're executing MatrixAnimator2D from.
This is the file from where you'll interact with the application.  
##### Script requirements:
* A function called _createAnimation_ with one parameter (the MatrixFrame instance).
##### Script code example:
```
function createAnimation(matrixFrame) {
	var MatrixScene = Java.type("me.eduardwayland.matrixanimator.matrix.MatrixScene");
	var matrixScene1 = new MatrixScene(java.awt.Color.GREEN);
	var matrixScene2 = new MatrixScene(java.awt.Color.GRAY);

	var y;
	var x;
	for (y = 0; y < matrixFrame.getRows(); y++) {
		for (x = 0; x < matrixFrame.getCols(); x++) {
	    	if (y % 2 == 0) matrixScene1.fillCell(y, x);
	        else matrixScene2.fillCell(y, x);
	    }
	}

	matrixFrame.addMatrixScene(matrixScene1);
	matrixFrame.addMatrixScene(matrixScene2);
}
```
##### Execution
There are two available startup arguments: y(rows) and x(columns).  
`java -jar MatrixAnimator2D.jar <rows> <columns>`
