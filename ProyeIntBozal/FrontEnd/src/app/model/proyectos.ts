export class Proyectos {
    id?: number;
    nombreP!: string;
    descripcionP!: string;
    imgP!: string;

    constructor(nombreE: string, descricionE: string, imgP: string) {
        this.nombreP = nombreE;
        this.descripcionP = descricionE;
        this.imgP = imgP;
    }

}


