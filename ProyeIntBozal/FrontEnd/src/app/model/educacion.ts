export class Educacion {
    id?: number;
    nombreE: string;
    descripcionE: string;
    startE: string;
    endE: string;


    constructor(nombreE: string, descricionE: string, startE: string, endE: string) {
        this.nombreE = nombreE;
        this.descripcionE = descricionE;
        this.startE = startE;
        this.endE = endE;
    }

}
