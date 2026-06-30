import { ChangeDetectionStrategy, Component } from '@angular/core';

@Component({

selector:'app-users-page',

standalone:true,

template:'<h1>Users</h1>',

changeDetection:ChangeDetectionStrategy.OnPush

})

export class UsersPage{}