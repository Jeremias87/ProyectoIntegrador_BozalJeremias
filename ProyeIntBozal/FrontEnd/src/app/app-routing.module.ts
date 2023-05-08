import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { NewExperienciaComponent } from './experience/new-experiencia.component';
import { EditExperienciaComponent } from './experience/edit-experiencia.component';
import { NewEducacionComponent } from './education/new-educacion.component';
import { EditEducacionComponent } from './education/edit-educacion.component';
import { NewSkillComponent } from './skills/new-skill.component';
import { EditSkillComponent } from './skills/edit-skill.component';
import { NewProyectoComponent } from './proyects/new-proyecto.component';
import { EditProyectoComponent } from './proyects/edit-proyecto.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'nuevaexp', component: NewExperienciaComponent },
  { path: 'editexp/:id', component: EditExperienciaComponent },
  { path: 'nuevaedu', component: NewEducacionComponent },
  { path: 'editedu/:id', component: EditEducacionComponent },
  { path: 'editskill/:id', component: EditSkillComponent },
  { path: 'nuevaskills', component: NewSkillComponent },
  { path: 'editproy/:id', component: EditProyectoComponent },
  { path: 'nuevoproy', component: NewProyectoComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
