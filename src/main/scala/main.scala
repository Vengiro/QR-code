package main.scala

@main def QRcode(args: String*) =
    val qr = Qr("Hello", 21)
    val code = qr.fill_fixe_modules()
    qr.printall(code)  
    
    
