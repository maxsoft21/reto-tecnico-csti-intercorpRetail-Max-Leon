import { Component, OnInit, ViewChild } from '@angular/core';
import { Person } from '../../model/person.model';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { DISPLAY_COLUMN_TABLE } from '../../helpers/actions';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { PersonService } from '../../services/person.service';
import { RouterModule, RouterOutlet,Router } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-person-new',
  standalone: true,
  imports: [RouterOutlet,
    MatTableModule,
    MatPaginatorModule,
    MatFormFieldModule,MatIconModule,MatInputModule,CommonModule, RouterModule
  ],
  templateUrl: './person-new.component.html',
  styleUrl: './person-new.component.css'
})
export class PersonNewComponent implements OnInit{
  listaPerson: Person[] = [];

  dataSource: MatTableDataSource<Person>;
  displayedColumns: string[] = DISPLAY_COLUMN_TABLE;
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(public personService: PersonService,
    private readonly router: Router,) { }

  ngOnInit(): void {
    this.cargarPersonas()
  }
  cargarPersonas() {
    this.personService.listarPerson().subscribe(

      (data: Person[]) => {
        this.listaPerson = data;
        this.dataSource = new MatTableDataSource(data);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
        // Almacena los datos en la propiedad del componente
      console.log(data)
      },

      error => {
        console.error('Error al obtener personas', error);
      }
    );
  }

  filtrar(e: any) {
    this.dataSource.filter = e.target.value.trim().toLowerCase();
  }

  viewUpdatePerson(){
    this.router.navigate(["person-update"]);
  }

  viewRoot(){
    this.router.navigate(["root"]);
  }
}
