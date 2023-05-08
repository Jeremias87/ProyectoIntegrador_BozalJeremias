import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Skills } from '../model/skills';
import { SSkillsService } from '../service/s-skills.service';

@Component({
  selector: 'app-new-skill',
  templateUrl: './new-skill.component.html',
  styleUrls: ['./new-skill.component.css']
})


export class NewSkillComponent implements OnInit {
  nombreS: string = '';
  porcentaje: number;
  constructor(private sSkills: SSkillsService, private router: Router) { }
  ngOnInit(): void {

  }
  OnCreate(): void {
    const skil = new Skills(this.nombreS, this.porcentaje);
    this.sSkills.save(skil).subscribe(data => {
      alert("Skill agregada");
      this.router.navigate(['']);
    }, err => {
      alert("fallo");
      this.router.navigate(['']);
    }
    )
  }
}
