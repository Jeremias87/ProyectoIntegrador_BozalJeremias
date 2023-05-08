import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { AcercaDeComponent } from './acerca-de/acerca-de.component';
import { ExperienceComponent } from './experience/experience.component';
import { EducationComponent } from './education/education.component';
import { ProyectsComponent } from './proyects/proyects.component';
import { FooterComponent } from './footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { interceptorProvider } from './service/interceptor-service';
import { NewExperienciaComponent } from './experience/new-experiencia.component';
import { EditExperienciaComponent } from './experience/edit-experiencia.component';
import { EditEducacionComponent } from './education/edit-educacion.component';
import { NewEducacionComponent } from './education/new-educacion.component';
import { SkillsComponent } from './skills/skills.component';
import { NewSkillComponent } from './skills/new-skill.component';
import { EditSkillComponent } from './skills/edit-skill.component';
import { NewProyectoComponent } from './proyects/new-proyecto.component';
import { EditProyectoComponent } from './proyects/edit-proyecto.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AcercaDeComponent,
    ExperienceComponent,
    EducationComponent,
    ProyectsComponent,
    FooterComponent,
    LoginComponent,
    HomeComponent,
    NewExperienciaComponent,
    EditExperienciaComponent,
    EditEducacionComponent,
    NewEducacionComponent,
    SkillsComponent,
    NewSkillComponent,
    EditSkillComponent,
    NewProyectoComponent,
    EditProyectoComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule

  ],
  providers: [
    interceptorProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
