import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { SEducacionService } from '../service/s-educacion.service';
import { Educacion } from '../model/educacion';

@Component({
  selector: 'app-edit-educacion',
  templateUrl: './edit-educacion.component.html',
  styleUrls: ['./edit-educacion.component.css']
})
export class EditEducacionComponent implements OnInit {
  eduLab: Educacion = null;

  constructor(private sEducacion: SEducacionService, private activatedRouter: ActivatedRoute, private router: Router) { }
  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sEducacion.detail(id).subscribe(
      data => {
        this.eduLab = data;
      }, err => {
        alert("Error al modificar Educacion");
        this.router.navigate(['']);
      }
    )
  }
  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sEducacion.update(id, this.eduLab).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert("Error al modificar Educacion");
        this.router.navigate(['']);
      }
    )
  }

}
