import { Component, OnInit } from '@angular/core';
import { TokenService } from '../service/token.service';
import { SProyectosService } from '../service/s-proyectos.service';
import { Proyectos } from '../model/proyectos';


@Component({
  selector: 'app-proyects',
  templateUrl: './proyects.component.html',
  styleUrls: ['./proyects.component.css']
})
export class ProyectsComponent implements OnInit {
  proy: Proyectos[] = [];

  constructor(private sProyecto: SProyectosService, private tokenService: TokenService) { }

  isLogged = false;


  ngOnInit(): void {
    this.cargarSkills();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarSkills(): void {
    this.sProyecto.lista().subscribe(
      data => { this.proy = data; })
  }

  delete(id?: number) {
    if (id != undefined) {
      this.sProyecto.delete(id).subscribe(
        data => {
          this.cargarSkills();
        }, err => {
          alert("No se pudo borrar la Skill");
        }
      )
    }
  }


}

