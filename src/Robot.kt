import java.text.FieldPosition

class Robot  {

    var xCoord: Int = 0
    var yCoord: Int = 0
    var xPos : Int = 0
    var yPos : Int = 0
    lateinit var instructions: CharArray
    var orientation : Char? = null
    private lateinit var xRange : IntRange
    private lateinit var yRange : IntRange


    fun startRobot() {
        xRange = -xCoord..xCoord
        yRange = -yCoord..yCoord

        if (validateInput()) {
            instructions?.forEach { move->
                navigateRobot(move)

            }
         println("Output $xPos $yPos $orientation")
        }

    }

    private fun validateInput(): Boolean {
//        if (xCoord == 0 || yCoord == 0) {
//            println("Please enter proper coordinates")
//            return false
//        }

        if (instructions?.size == 0) {
            println("No movements. Please enter proper instructions to navigate the robot.")
            return false
        }

        if (xPos > xCoord || yPos > yCoord) {
            println("Invalid positions. Please enter proper position to navigate the robot.")
            return false
        }

        return true
    }

    private fun navigateRobot(singleInstruction: Char) {

        when (singleInstruction) {
            'L' -> {
                //println("Rotate 90 left")
                checkEachMove(singleInstruction)
            }
            'R' -> {
                //println("Rotate 90 right")
                checkEachMove(singleInstruction)
            }
            'M' -> {
                //println("Move 1 step forward")
                moveXAndY()
            }
            else -> println("Invalid instruction")
        }
    }

    private fun moveXAndY(){
        when (orientation) {
            'N' ->{
                if(isValidMove()) {
                    yPos += 1
                }
                //println("North orientation $xPos $yPos")
            }

            'S' -> {
                if(isValidMove()) {
                    yPos -= 1
                }
               // println("South orientation $xPos $yPos")
            }
            'E' -> {
                //println("East orientation")
                if(isValidMove()) {
                    xPos += 1
                }
               // println("East orientation $xPos $yPos")
            }
            'W' -> {
                //println("West orientation")
                if(isValidMove()) {
                    xPos -= 1
                }
             //   println("West orientation $xPos $yPos")
            }
            else -> println("Invalid movement")
        }
    }

    private fun isValidMove():Boolean{
        if(xPos in xRange && yPos in yRange){
            return true
        }else{
            println("Invalid move.Skipping this move")
            return false
        }
    }

    private fun checkEachMove(singleInstruction: Char){
        when (orientation) {
            'N' ->{
                orientation = if (isLeftRotate(singleInstruction) )'W' else 'E'
               // println("N to $orientation")
            }

            'S' -> {
                orientation = if (isLeftRotate(singleInstruction) )'E' else 'W'
             //   println("S to $orientation")
            }
            'E' -> {
                orientation = if (isLeftRotate(singleInstruction) )'N' else 'S'
              //  println("E to $orientation")
            }
            'W' -> {
                orientation = if (isLeftRotate(singleInstruction) )'S' else 'N'
              //  println("W to $orientation")
            }
            else -> println("Invalid orientation")
        }
    }

    private fun isLeftRotate(singleInstruction: Char):Boolean =  singleInstruction.equals('L',true)

    }