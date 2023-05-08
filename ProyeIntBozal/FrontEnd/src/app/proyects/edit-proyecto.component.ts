import { Component, OnInit } from '@angular/core';
import { Experiencia } from '../model/experiencia';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { SProyectosService } from '../service/s-proyectos.service';
import { Proyectos } from '../model/proyectos';

@Component({
  selector: 'app-edit-proyecto',
  templateUrl: './edit-proyecto.component.html',
  styleUrls: ['./edit-proyecto.component.css']
})
export class EditProyectoComponent implements OnInit {
  proyLab: Proyectos = null;

  constructor(private sProyectos: SProyectosService, private activatedRouter: ActivatedRoute, private router: Router) { }
  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sProyectos.detail(id).subscribe(
      data => {
        this.proyLab = data;
      }, err => {
        alert("Error al modificar Proyecto");
        this.router.navigate(['']);
      }
    )
  }
  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sProyectos.update(id, this.proyLab).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert("Error al modificar Proyecto");
        this.router.navigate(['']);
      }
    )
  }

}
