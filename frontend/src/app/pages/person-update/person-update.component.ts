import { CommonModule } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterModule, RouterOutlet,Router } from '@angular/router';
import { PersonUpdated } from '../../model/person.model-upd';
import { MatSort } from '@angular/material/sort';
import { PersonService } from '../../services/person.service';
import { DISPLAY_COLUMN_TABLE } from '../../helpers/actions';

@Component({
  selector: 'app-person-update',
  standalone: true,
  imports: [RouterOutlet,
    MatTableModule,
    MatPaginatorModule,
    MatFormFieldModule,MatIconModule,MatInputModule,CommonModule, RouterModule
  ],
  templateUrl: './person-update.component.html',
  styleUrl: './person-update.component.css'
})
export class PersonUpdateComponent implements OnInit{
  listaPerson: PersonUpdated[] = [];

  dataSource: MatTableDataSource<PersonUpdated>;
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

      (data: PersonUpdated[]) => {
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
  
  viewRoot(){
    this.router.navigate(["root"]);
  }
}

