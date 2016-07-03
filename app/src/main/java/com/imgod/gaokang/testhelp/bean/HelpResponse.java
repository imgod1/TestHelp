package com.imgod.gaokang.testhelp.bean;

import java.util.List;

/**
 * 项目名称：TestHelp
 * 包名称：com.imgod.gaokang.testhelp.bean
 * 类描述：
 * 创建人：gaokang
 * 创建时间：2016-07-01 15:06
 * 修改人：gaokang
 * 修改时间：2016-07-01 15:06
 * 修改备注：
 */
public class HelpResponse {


    /**
     * code : 0000
     * data : {"helpList":[{"uid":"1bf3cnemitfy6dnlsfk8","controlName":"下拉列表","controlType":"lisetview","title":"test","viewindex":0,"customId":"","helpInfo":{"helpId":"3c7ul173h753wvsrradd","message":"哈哈哈哈 修改","voicePath":""}},{"uid":"242nrr77zqy0p17uobyt","controlName":"下拉列表","controlType":"lisetview","title":"test","viewindex":0,"customId":"","helpInfo":{"helpId":"1ik5femcd4pxseok06ja","message":"哈哈哈哈","voicePath":"http://192.168.1.31:8089/AppAssistWebservice/file/sound/Koala.jpg"}},{"uid":"3uhxjdza77x8vlvqkag6","controlName":"下拉列表","controlType":"lisetview","title":"test","viewindex":0,"customId":"","helpInfo":{"helpId":"k8yyiv0ufyfy28vi29z4","message":"哈哈哈哈 修改","voicePath":""}},{"uid":"iighiz4322hxab3ch4rn","controlName":"按钮","controlType":"button","title":"新增库存","viewindex":0,"customId":"","helpInfo":{"helpId":"","message":"","voicePath":""}},{"uid":"mpb7harr82cad5lgeiwj","controlName":"按钮","controlType":"button","title":"我是谁","viewindex":-1,"customId":"","helpInfo":{"helpId":"cbblxdzoca50zuydh2ho","message":"test","voicePath":""}},{"uid":"nwdzakpk4gh8rjzv7hap","controlName":"按钮","controlType":"button","title":"55","viewindex":0,"customId":"","helpInfo":{"helpId":"btck0fkho9g57384w3m8","message":"哈哈哈哈h 测试","voicePath":"http://192.168.1.31:8089/AppAssistWebservice/file/sound/20160630170405_icon_share.png"}},{"uid":"og4f30f260tmuxl1zyjg","controlName":"按钮","controlType":"button","title":"111","viewindex":0,"customId":"","helpInfo":{"helpId":"","message":"","voicePath":""}},{"uid":"r1erdr9dm1ix32e17vrw","controlName":"按钮","controlType":"button","title":"测试按钮","viewindex":0,"customId":"","helpInfo":{"helpId":"","message":"","voicePath":""}},{"uid":"r491lwq5yct19hnnjvxy","controlName":"按钮","controlType":"button","title":"111","viewindex":0,"customId":"","helpInfo":{"helpId":"zjlwxu6oogabru9092ib","message":"","voicePath":"http://192.168.1.31:8089/AppAssistWebservice/file/sound/20160630170846_icon_share.png"}},{"uid":"svnxpqtblym7oqj9zjf7","controlName":"按钮","controlType":"button","title":"444","viewindex":0,"customId":"","helpInfo":{"helpId":"vbbgkx5ch322wjp3dqds","message":"我是44444","voicePath":"http://192.168.1.31:8089/AppAssistWebservice/file/sound/20160701091437_icon_setting.png"}},{"uid":"tcrw2z97oblev58ls9rf","controlName":"高级下拉列表","controlType":"highlisetview","title":"下拉","viewindex":1111,"customId":"111","helpInfo":{"helpId":"","message":"","voicePath":""}},{"uid":"tyjg9g4c2sxuqh64khre","controlName":"下拉列表","controlType":"lisetview","title":"test","viewindex":0,"customId":"","helpInfo":{"helpId":"lr7pshocqe6shmhczoak","message":"哈哈哈哈 修改","voicePath":""}},{"uid":"y96t6zuqug8ix1rm1pov","controlName":"下拉列表","controlType":"lisetview","title":"test","viewindex":0,"customId":"","helpInfo":{"helpId":"3hz9v3bf17i9xutf5ac4","message":"1","voicePath":""}}],"qaList":[{"qaId":"pehqbiap448fvtbsiv3r","question":"1","answer":"1","sort":1},{"qaId":"9jzaelpwln2w4wmhbqc6","question":"2","answer":"2","sort":2}]}
     */

    private String code;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * uid : 1bf3cnemitfy6dnlsfk8
         * controlName : 下拉列表
         * controlType : lisetview
         * title : test
         * viewindex : 0
         * customId :
         * helpInfo : {"helpId":"3c7ul173h753wvsrradd","message":"哈哈哈哈 修改","voicePath":""}
         */

        private List<HelpListBean> helpList;
        /**
         * qaId : pehqbiap448fvtbsiv3r
         * question : 1
         * answer : 1
         * sort : 1
         */

        private List<QaListBean> qaList;

        public List<HelpListBean> getHelpList() {
            return helpList;
        }

        public void setHelpList(List<HelpListBean> helpList) {
            this.helpList = helpList;
        }

        public List<QaListBean> getQaList() {
            return qaList;
        }

        public void setQaList(List<QaListBean> qaList) {
            this.qaList = qaList;
        }

        public static class HelpListBean {
            private String uid;
            private String controlName;
            private String controlType;
            private String title;
            private int viewindex;
            private String customId;
            /**
             * helpId : 3c7ul173h753wvsrradd
             * message : 哈哈哈哈 修改
             * voicePath :
             */

            private HelpInfoBean helpInfo;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getControlName() {
                return controlName;
            }

            public void setControlName(String controlName) {
                this.controlName = controlName;
            }

            public String getControlType() {
                return controlType;
            }

            public void setControlType(String controlType) {
                this.controlType = controlType;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getViewindex() {
                return viewindex;
            }

            public void setViewindex(int viewindex) {
                this.viewindex = viewindex;
            }

            public String getCustomId() {
                return customId;
            }

            public void setCustomId(String customId) {
                this.customId = customId;
            }

            public HelpInfoBean getHelpInfo() {
                return helpInfo;
            }

            public void setHelpInfo(HelpInfoBean helpInfo) {
                this.helpInfo = helpInfo;
            }

            public static class HelpInfoBean {
                private String helpId;
                private String message;
                private String voicePath;

                public String getHelpId() {
                    return helpId;
                }

                public void setHelpId(String helpId) {
                    this.helpId = helpId;
                }

                public String getMessage() {
                    return message;
                }

                public void setMessage(String message) {
                    this.message = message;
                }

                public String getVoicePath() {
                    return voicePath;
                }

                public void setVoicePath(String voicePath) {
                    this.voicePath = voicePath;
                }
            }
        }

        public static class QaListBean {
            private String qaId;
            private String question;
            private String answer;
            private int sort;

            public String getQaId() {
                return qaId;
            }

            public void setQaId(String qaId) {
                this.qaId = qaId;
            }

            public String getQuestion() {
                return question;
            }

            public void setQuestion(String question) {
                this.question = question;
            }

            public String getAnswer() {
                return answer;
            }

            public void setAnswer(String answer) {
                this.answer = answer;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }
        }
    }
}
