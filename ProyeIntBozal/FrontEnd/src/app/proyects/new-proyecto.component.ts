
import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { SProyectosService } from '../service/s-proyectos.service';
import { Proyectos } from '../model/proyectos';

@Component({
  selector: 'app-new-proyecto',
  templateUrl: './new-proyecto.component.html',
  styleUrls: ['./new-proyecto.component.css']
})

export class NewProyectoComponent implements OnInit {
  nombreP: string = '';
  descripcionP: string = '';
  imgP: string = '';

  constructor(private sProyecto: SProyectosService, private router: Router) { }
  ngOnInit(): void {

  }
  OnCreate(): void {
    const edu = new Proyectos(this.nombreP, this.descripcionP, this.imgP);
    this.sProyecto.save(edu).subscribe(data => {
      alert("Proyecto agregado");
      this.router.navigate(['']);
    }, err => {
      alert("fallo");
      this.router.navigate(['']);
    }
    )
  }
}
