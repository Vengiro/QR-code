import scala.annotation.tailrec

def degre(n: Int): Int =
    @tailrec
    def tailrecdeg(n: Int, acc: Int): Int =
        if n == 0 then acc
        else tailrecdeg(n<<1, acc + 1)
    if n == 0 then 0
    else tailrecdeg(n, -1)

@tailrec
def modulo(p: Int, q: Int): Int =

    val pdeg = degre(p)
    val qdeg = degre(q)
    if pdeg < qdeg then p
    else modulo(p ^ (q << (pdeg - qdeg)), q)



    
