package model.vo;

public class CustomerBoardVO {

    private  int replyId;
    private  int originId;
    private int articleId;
    private String writingTime;
    private String title;
    private String content;
    private String tel;
    private String id;
    private int readCount;

    private CustomerBoardPagingVO customerBoardPagingVO;

    public CustomerBoardPagingVO getCustomerBoardPagingVO() {
        return customerBoardPagingVO;
    }

    public void setCustomerBoardPagingVO(CustomerBoardPagingVO customerBoardPagingVO) {
        this.customerBoardPagingVO = customerBoardPagingVO;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getWritingTime() {
        return writingTime;
    }

    public void setWritingTime(String writingTime) {
        this.writingTime = writingTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }
    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public int getOriginId() {
        return originId;
    }

    public void setOriginId(int originId) {
        this.originId = originId;
    }
}
