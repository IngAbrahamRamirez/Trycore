import {
    ChangeDetectionStrategy,
    Component,
    computed,
    input
} from '@angular/core';

import { AvatarModel } from './avatar.model';

@Component({

    selector: 'app-avatar',

    standalone: true,

    templateUrl: './avatar.html',

    styleUrl: './avatar.scss',

    changeDetection: ChangeDetectionStrategy.OnPush

})

export class AvatarComponent {

    readonly model = input.required<AvatarModel>();

    readonly initials = computed(() => {

        const parts = this.model().name
            .trim()
            .split(' ')
            .filter(Boolean);

        if (parts.length === 1) {

            return parts[0].substring(0, 2).toUpperCase();

        }

        return (
            parts[0][0] +
            parts[parts.length - 1][0]
        ).toUpperCase();

    });

}