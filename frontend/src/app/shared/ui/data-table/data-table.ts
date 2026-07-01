import {
  ChangeDetectionStrategy,
  Component,
  input
} from '@angular/core';

import { DataTableModel } from '../../models/data-table.model';

@Component({
  selector: 'app-data-table',
  standalone: true,
  templateUrl: './data-table.html',
  styleUrl: './data-table.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})

export class DataTableComponent {

  readonly model = input.required<DataTableModel>();

}