package com.passion.demo.dto;

import lombok.Data;

/**
 * github 请求access-token返回的数据模型
 */
@Data
public class GitHubDto {

    /**
     * login : passionis
     * id : 19913083
     * node_id : MDQ6VXNlcjE5OTEzMDgz
     * avatar_url : https://avatars1.githubusercontent.com/u/19913083?v=4
     * gravatar_id :
     * url : https://api.github.com/users/passionis
     * html_url : https://github.com/passionis
     * followers_url : https://api.github.com/users/passionis/followers
     * following_url : https://api.github.com/users/passionis/following{/other_user}
     * gists_url : https://api.github.com/users/passionis/gists{/gist_id}
     * starred_url : https://api.github.com/users/passionis/starred{/owner}{/repo}
     * subscriptions_url : https://api.github.com/users/passionis/subscriptions
     * organizations_url : https://api.github.com/users/passionis/orgs
     * repos_url : https://api.github.com/users/passionis/repos
     * events_url : https://api.github.com/users/passionis/events{/privacy}
     * received_events_url : https://api.github.com/users/passionis/received_events
     * type : User
     * site_admin : false
     * name : null
     * company : null
     * blog :
     * location : null
     * email : null
     * hireable : null
     * bio : null
     * public_repos : 3
     * public_gists : 0
     * followers : 0
     * following : 1
     * created_at : 2016-06-13T16:27:06Z
     * updated_at : 2019-09-28T12:19:32Z
     * private_gists : 0
     * total_private_repos : 2
     * owned_private_repos : 2
     * disk_usage : 14125
     * collaborators : 0
     * two_factor_authentication : false
     * plan : {"name":"free","space":976562499,"collaborators":0,"private_repos":10000}
     */

    private String login;
    private int id;
    private String node_id;
    private String avatar_url;
    private String gravatar_id;
    private String url;
    private String html_url;
    private String followers_url;
    private String following_url;
    private String gists_url;
    private String starred_url;
    private String subscriptions_url;
    private String organizations_url;
    private String repos_url;
    private String events_url;
    private String received_events_url;
    private String type;
    private boolean site_admin;
    private Object name;
    private Object company;
    private String blog;
    private Object location;
    private Object email;
    private Object hireable;
    private Object bio;
    private int public_repos;
    private int public_gists;
    private int followers;
    private int following;
    private String created_at;
    private String updated_at;
    private int private_gists;
    private int total_private_repos;
    private int owned_private_repos;
    private int disk_usage;
    private int collaborators;
    private boolean two_factor_authentication;
    private PlanBean plan;

    @Data
    public static class PlanBean {
        /**
         * name : free
         * space : 976562499
         * collaborators : 0
         * private_repos : 10000
         */

        private String name;
        private int space;
        private int collaborators;
        private int private_repos;

    }
}
