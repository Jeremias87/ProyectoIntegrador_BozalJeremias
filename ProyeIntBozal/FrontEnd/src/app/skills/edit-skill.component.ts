import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Skills } from '../model/skills';
import { SSkillsService } from '../service/s-skills.service';

@Component({
  selector: 'app-edit-skill',
  templateUrl: './edit-skill.component.html',
  styleUrls: ['./edit-skill.component.css']
})
export class EditSkillComponent implements OnInit {
  skillsLab: Skills = null;

  constructor(private sSkills: SSkillsService, private activatedRouter: ActivatedRoute, private router: Router) { }
  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sSkills.detail(id).subscribe(
      data => {
        this.skillsLab = data;
      }, err => {
        alert("Error al modificar Skill");
        this.router.navigate(['']);
      }
    )
  }
  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sSkills.update(id, this.skillsLab).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert("Error al modificar Skill");
        this.router.navigate(['']);
      }
    )
  }

}
