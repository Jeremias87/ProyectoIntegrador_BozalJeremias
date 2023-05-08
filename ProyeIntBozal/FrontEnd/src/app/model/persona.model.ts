export class persona {
    id?: number;
    nombre: String;
    apellido: String;
    img: string;
    oficio: string;
    sobremi: string;

    constructor(nombre: string, apellido: string, oficio: string, sobremi: string, img: string) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.oficio = oficio;
        this.img = img;
        this.sobremi = sobremi;
    }
}