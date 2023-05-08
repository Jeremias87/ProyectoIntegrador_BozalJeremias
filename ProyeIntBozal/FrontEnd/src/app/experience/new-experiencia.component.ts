import { Component, OnInit } from '@angular/core';
import { SExperienciaService } from '../service/s-experiencia.service';
import { Route, Router } from '@angular/router';
import { Experiencia } from '../model/experiencia';

@Component({
  selector: 'app-new-experiencia',
  templateUrl: './new-experiencia.component.html',
  styleUrls: ['./new-experiencia.component.css']
})


export class NewExperienciaComponent implements OnInit {
  nombreE: string = '';
  descripcionE: string = '';
  startE: string = '';
  endE: string = '';
  constructor(private sExperiencia: SExperienciaService, private router: Router) { }
  ngOnInit(): void {

  }
  OnCreate(): void {
    const expe = new Experiencia(this.nombreE, this.descripcionE, this.startE, this.endE);
    this.sExperiencia.save(expe).subscribe(data => {
      alert("Experiencia agregada");
      this.router.navigate(['']);
    }, err => {
      alert("fallo");
      this.router.navigate(['']);
    }
    )
  }
}

