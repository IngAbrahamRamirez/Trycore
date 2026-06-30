import {
    ChangeDetectionStrategy,
    Component,
    input
} from '@angular/core';

import { PageHeaderModel } from '../../models/page-header.model';

@Component({

    selector: 'app-page-header',

    standalone: true,

    templateUrl: './page-header.html',

    styleUrl: './page-header.scss',

    changeDetection: ChangeDetectionStrategy.OnPush

})
export class PageHeaderComponent {

    readonly model = input.required<PageHeaderModel>();

}