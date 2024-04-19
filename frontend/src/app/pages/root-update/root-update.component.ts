import { CommonModule } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterModule, RouterOutlet } from '@angular/router';
import { RootUpdated } from '../../model/root.model-upd';
import { DISPLAY_COLUMN_TABLE_ROOT_UPDATE } from '../../helpers/actions';
import { MatSort } from '@angular/material/sort';
import { RootService } from '../../services/root.service';

@Component({
  selector: 'app-root-update',
  standalone: true,
  imports: [RouterOutlet,
    MatTableModule,
    MatPaginatorModule,
    MatFormFieldModule,MatIconModule,MatInputModule,CommonModule, RouterModule
  ],
  templateUrl: './root-update.component.html',
  styleUrl: './root-update.component.css'
})
export class RootUpdateComponent  implements OnInit{
  listaRoot: RootUpdated[] = [];

  dataSource: MatTableDataSource<RootUpdated>;
  displayedColumns: string[] = DISPLAY_COLUMN_TABLE_ROOT_UPDATE;
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(public rootService: RootService) { }

  ngOnInit(): void {
    this.cargarRoot()
  }
  cargarRoot() {
    this.rootService.listarRootUpd().subscribe(
      (data: RootUpdated[]) => {
        this.listaRoot = data;
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
}
