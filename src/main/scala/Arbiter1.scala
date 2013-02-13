import Chisel._

class Arbiter1 extends Component {
val io = new Bundle {
val req0 = Bits(INPUT, 1)
val req1 = Bits(INPUT, 1)
val grant0 = Bits(OUTPUT, 1) 
val grant1 = Bits(OUTPUT, 1) 
}

val count = Reg(resetVal = UFix(0))

count := ~count
when (count === UFix(0)) {
     io.grant0 := io.req0
     io.grant1 := (io.req0 & UFix(0)) | (~io.req0 & io.req1)
}.elsewhen(count === UFix(1)){
     io.grant1 := io.req1
     io.grant0 := (io.req1 & UFix(0)) | (~io.req1 & io.req0) 
}
}
