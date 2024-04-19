import { CommonModule } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterModule, RouterOutlet } from '@angular/router';
import { MatSort } from '@angular/material/sort';
import {  DISPLAY_COLUMN_TABLE_ROOT } from '../../helpers/actions';
import { Root } from '../../model/root.model';
import { RootService } from '../../services/root.service';
@Component({
  selector: 'app-root-new',
  standalone: true,
  imports: [RouterOutlet,
    MatTableModule,
    MatPaginatorModule,
    MatFormFieldModule,MatIconModule,MatInputModule,CommonModule, RouterModule
  ],
  templateUrl: './root-new.component.html',
  styleUrl: './root-new.component.css'
})
export class RootNewComponent implements OnInit{
  listaRoot: Root[] = [];

  dataSource: MatTableDataSource<Root>;
  displayedColumns: string[] = DISPLAY_COLUMN_TABLE_ROOT;
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(public rootService: RootService) { }

  ngOnInit(): void {
    this.cargarRoot()
  }
  cargarRoot() {
    this.rootService.listarRoot().subscribe(
      (data: Root[]) => {
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
