import javax.xml.stream.events.ProcessingInstruction

fun main(args : Array<String>) {

    try {
        println("Please enter the coordinates")
        val (xCoordinate, yCoordinate) = readLine()!!.split(' ').map(String::toInt)
        println("Please enter the postions and orientation")
        val (xPosition, yPosition, direction) = readLine()!!.split(' ')
        println("Please enter the instructions")
        val robotInstruction = readLine()!!


        var robot = Robot().apply {
            xCoord = xCoordinate
            yCoord = yCoordinate
            xPos = xPosition.toInt()
            yPos = yPosition.toInt()
            orientation = direction.first()
            instructions = robotInstruction.toCharArray()
        }
        robot.startRobot()

    }catch (e:Exception){
        println("Invalid input")
    }




}



