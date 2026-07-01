import { ChangeDetectionStrategy, Component, input } from '@angular/core';

import {
    DataTableColumn,
    DataTableModel
} from '../../models/data-table.model';

import { StatusChipModel } from '../status-chip/status-chip.model';
import { ProgressBarModel } from '../progress-bar/progress-bar.model';
import { AvatarModel } from '../avatar/avatar.model';

import { StatusChipComponent } from '../status-chip/status-chip';
import { ProgressBarComponent } from '../progress-bar/progress-bar';
import { AvatarComponent } from '../avatar/avatar';

@Component({

    selector: 'app-data-table',

    standalone: true,

    imports: [

        StatusChipComponent,

        ProgressBarComponent,

        AvatarComponent

    ],

    templateUrl: './data-table.html',

    styleUrl: './data-table.scss',

    changeDetection: ChangeDetectionStrategy.OnPush

})

export class DataTableComponent {

    readonly model = input.required<DataTableModel>();

    isType(column: DataTableColumn, type: string): boolean {

        return column.type === type;

    }

    getStatus(row: Record<string, unknown>, field: string): StatusChipModel {

        return row[field] as StatusChipModel;

    }

    getProgress(row: Record<string, unknown>, field: string): ProgressBarModel {

        return row[field] as ProgressBarModel;

    }

    getAvatar(row: Record<string, unknown>, field: string): AvatarModel {

        return row[field] as AvatarModel;

    }

}