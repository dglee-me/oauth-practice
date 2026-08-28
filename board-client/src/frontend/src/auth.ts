import {UserManager, WebStorageStateStore,} from 'oidc-client-ts'

export const userManager = new UserManager({
    authority: 'http://localhost:8080',
    client_id: 'board-frontend',
    redirect_uri: 'http://localhost:5173/callback',
    post_logout_redirect_uri: 'http://localhost:5173/',
    response_type: 'code',
    scope: 'openid profile read',

    stateStore: new WebStorageStateStore({
        store: window.sessionStorage,
    }),

    userStore: new WebStorageStateStore({
        store: window.sessionStorage,
    }),
})
