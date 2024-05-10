import Qr._


@main def QRcode(args: String*) =
    qr = Qr("Hello", 21)
    qr.fill_fixe_modules()
    qr.printall(qr.qr)  
    
    
