import { Component, OnInit } from '@angular/core';
import { TokenService } from '../service/token.service';
import { SSkillsService } from '../service/s-skills.service';
import { Skills } from '../model/skills';


@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {
  skil: Skills[] = [];

  constructor(private sSkills: SSkillsService, private tokenService: TokenService) { }

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
    this.sSkills.lista().subscribe(
      data => { this.skil = data; })
  }

  delete(id?: number) {
    if (id != undefined) {
      this.sSkills.delete(id).subscribe(
        data => {
          this.cargarSkills();
        }, err => {
          alert("No se pudo borrar la Skill");
        }
      )
    }
  }


}

