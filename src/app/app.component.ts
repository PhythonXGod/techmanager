import { Component, OnInit } from '@angular/core';
import { Tech } from './tech';
import { TechService } from './tech.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  public techs!: Tech[];
  public editTech!: Tech;
  public deleteTech!: Tech;
  public dota = (): string => {
    const d = new Date();
    d.setMinutes(d.getMinutes() - d.getTimezoneOffset());
    return d.toISOString().split('.')[0];
  };

  constructor(private techService: TechService) {}

  ngOnInit(): any {
      this.getTechs();
  }

  public getTechs(): void {
    this.techService.getTechs().subscribe(
      (response: Tech[]) => {
        this.techs = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddTech(addForm: NgForm): void {
    document.getElementById('add-tech-form')!.click();
    this.techService.addTech(addForm.value).subscribe(
      (response: Tech) => {
        console.log(response);
        this.getTechs();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateTech(tech: Tech): void {
    this.techService.updateTech(tech).subscribe(
      (response: Tech) => {
        console.log(response);
        this.getTechs();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteTech(techId: number): void {
    this.techService.deleteTech(techId).subscribe(
      (response: void) => {
        console.log(response);
        this.getTechs();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchTechs(key: string): void {
    console.log(key);
    const results: Tech[] = [];
    for (const employee of this.techs) {
      if (employee.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.description.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.properties.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.techCode.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(employee);
      }
    }
    this.techs = results;
    if (results.length === 0 || !key) {
      this.getTechs();
    }
  }

  public onOpenModal(tech: Tech, mode: string): void {
    console.log(mode)
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none'
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addTechModal');
    }
    if (mode === 'edit') {
      this.editTech = tech;
      button.setAttribute('data-target', '#updateTechModal');
    }
    if (mode === 'delete') {
      this.deleteTech = tech;
      button.setAttribute('data-target', '#deleteTechModal');
    }
    container?.appendChild(button);
    button.click();
  }
}
