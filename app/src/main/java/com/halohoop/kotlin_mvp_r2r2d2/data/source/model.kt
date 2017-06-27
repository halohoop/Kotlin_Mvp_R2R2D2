package com.halohoop.kotlin_mvp_r2r2d2.data.source

import com.google.gson.annotations.SerializedName

/**
 * Created by Pooholah on 2017/6/27.
 */

const val BASE_URL = "https://api.github.com/"

//序列化名字为login，但是为了方便理解，这里改成变成中使用name.
data class User(@SerializedName("login") var name: String, var avatar_url: String,
                var html_url: String, var score: String)

data class Users(var items: List<User>)

/**
 * {
"total_count": 12,
"incomplete_results": false,
"items": [
{
"login": "mojombo",
"id": 1,
"avatar_url": "https://secure.gravatar.com/avatar/25c7c18223fb42a4c6ae1c8db6f50f9b?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
"gravatar_id": "",
"url": "https://api.github.com/users/mojombo",
"html_url": "https://github.com/mojombo",
"followers_url": "https://api.github.com/users/mojombo/followers",
"subscriptions_url": "https://api.github.com/users/mojombo/subscriptions",
"organizations_url": "https://api.github.com/users/mojombo/orgs",
"repos_url": "https://api.github.com/users/mojombo/repos",
"received_events_url": "https://api.github.com/users/mojombo/received_events",
"type": "User",
"score": 105.47857
}
]
}
 */

//序列化名字为login，但是为了方便理解，这里改成变成中使用name.
data class User1(@SerializedName("login") var name: String, var avatar_url: String)

data class Users1(var items: List<User1>)
/**
{
    "total_count": 2,
    "items": [
        {
        "login": "halohoop",
        "avatar_url": "https://avatars3.githubusercontent.com/u/16235096?v=3",
        },
        {
        "login": "jakewharton",
        "avatar_url": "https://avatars3.githubusercontent.com/u/16235096?v=3",
        }
    ]
}
 */

//序列化名字为login，但是为了方便理解，这里改成变成中使用name.
data class User2(@SerializedName("login") var name: String?, var avatar_url: String?,
                 var followers: String?) {
    //分构造器
    constructor() : this(null, null, null) {
    }
}

/**
 *
{
"login": "halohoop",
"id": 16235096,
"avatar_url": "https://avatars3.githubusercontent.com/u/16235096?v=3",
"gravatar_id": "",
"url": "https://api.github.com/users/halohoop",
"html_url": "https://github.com/halohoop",
"followers_url": "https://api.github.com/users/halohoop/followers",
"following_url": "https://api.github.com/users/halohoop/following{/other_user}",
"gists_url": "https://api.github.com/users/halohoop/gists{/gist_id}",
"starred_url": "https://api.github.com/users/halohoop/starred{/owner}{/repo}",
"subscriptions_url": "https://api.github.com/users/halohoop/subscriptions",
"organizations_url": "https://api.github.com/users/halohoop/orgs",
"repos_url": "https://api.github.com/users/halohoop/repos",
"events_url": "https://api.github.com/users/halohoop/events{/privacy}",
"received_events_url": "https://api.github.com/users/halohoop/received_events",
"type": "User",
"site_admin": false,
"name": "Pooholah",
"company": "Pooholah",
"blog": "http://www.halohoop.com",
"location": "Guangdong SZ China",
"email": null,
"hireable": null,
"bio": "WeChat（微信号）:  halohoop\r\nE-Mail（邮件）:  halohoop@163.com\r\nNick Name（昵称）:  卖牙膏霸气侧漏农村有文化的芖口钉\r\nOpen for chatting.（欢迎交流）\r\n",
"public_repos": 52,
"public_gists": 0,
"followers": 10,
"following": 5,
"created_at": "2015-12-10T04:42:03Z",
"updated_at": "2017-06-27T04:29:55Z"
}
 */