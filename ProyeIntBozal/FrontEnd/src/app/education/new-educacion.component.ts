import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { SEducacionService } from '../service/s-educacion.service';
import { Educacion } from '../model/educacion';

@Component({
  selector: 'app-new-educacion',
  templateUrl: './new-educacion.component.html',
  styleUrls: ['./new-educacion.component.css']
})

export class NewEducacionComponent implements OnInit {
  nombreE: string = '';
  descripcionE: string = '';
  startE: string = '';
  endE: string = '';
  constructor(private sEducacion: SEducacionService, private router: Router) { }
  ngOnInit(): void {

  }
  OnCreate(): void {
    const edu = new Educacion(this.nombreE, this.descripcionE, this.startE, this.endE);
    this.sEducacion.save(edu).subscribe(data => {
      alert("Educacion agregada");
      this.router.navigate(['']);
    }, err => {
      alert("fallo");
      this.router.navigate(['']);
    }
    )
  }
}
