package com.traview.vo;

public class PagerVO {

    public PagerVO(int totRows, int curPage, int perPage) {
        
        this.totRows = Math.max(totRows, 0); // 전체 건수
        this.curPage = Math.max(curPage, 1); // 현재 페이지
        this.perPage = Math.max(perPage, 5); // 페이지 당 표시 건수
        
        compute();
    }

    public PagerVO(int totRows, int curPage) {
        
        this(totRows, curPage, 5);
    }

    public PagerVO(int totRows) {
        
        this(totRows, 1, 5);
    }
    
    private void compute() {

        //---------------------------------------------------------------------
        // 페이징 방식
        //---------------------------------------------------------------------
        // < [1] 2 3 4 5 > - 첫 페이지
        // < 1 [2] 3 4 5 >
        // < 1 2 [3] 4 5 >
        // < 2 3 [4] 5 6 >
        // < 2 3 4 [5] 6 >
        // < 2 3 4 5 [6] > - 마지막 페이지
        //---------------------------------------------------------------------
        // 기준 변수 초기화
        //---------------------------------------------------------------------
        // 페이징 표시 건수 (5 건으로 고정)
        this.pagePer = 5;
        // 페이지 당 표시 건수 초기화 (최소 5건을 표시 - 음수 체크 용)
        this.perPage = Math.max(this.perPage, 5);
        // 총 레코드 건수 초기화 (최소 레코드는 1건으로 정의 - 음수 체크 용)
        int rows = Math.max(this.totRows, 1);
        // 총 페이지 수를 구한다. (소수점 이하 버림)
        this.pageTot = (int)Math.floor((double)(rows / this.perPage));
        this.pageTot += (0 < (rows % this.perPage)) ? 1 : 0;
        // 현재 페이지 번호를 초기화 (1이상, 총 페이지수 이하 - 한계치 체크용)
        this.curPage = Math.min(this.pageTot, Math.max(this.curPage, 1));
        //---------------------------------------------------------------------
        // 레코드 번호 계산
        //---------------------------------------------------------------------
        // 레코드 시작 번호
        this.minRows = (this.curPage * this.perPage) - this.perPage + 1;
        // 레코드 종료 번호
        this.maxRows = this.minRows + this.perPage - 1;
        //---------------------------------------------------------------------
        // 페이징 번호 계산
        //---------------------------------------------------------------------
        // 페이징 시작 번호, 페이징 종료 번호
        if (5 < this.pageTot) {
            this.pageMin = Math.max(Math.min(this.curPage - 2, this.pageTot - 4), 1);
            this.pageMax = Math.max(Math.min(this.curPage + 2, this.pageTot), 5);
        } else {
            this.pageMin = 1;
            this.pageMax = this.pageTot;
        }
        //---------------------------------------------------------------------
    }
    
    private int curPage;
    private int totRows;
    private int perPage;
    private int pageTot;
    private int pagePer;
    private int pageMin;
    private int pageMax;
    private int minRows;
    private int maxRows;
    
    /**
     * @return the curPage
     */
    public int getCurPage() {
    
        return curPage;
    }

    
    /**
     * @param curPage the curPage to set
     */
    public void setCurPage(int curPage) {
    
        this.curPage = curPage;
    }

    
    /**
     * @return the totRows
     */
    public int getTotRows() {
    
        return totRows;
    }

    
    /**
     * @param totRows the totRows to set
     */
    public void setTotRows(int totRows) {
    
        this.totRows = totRows;
    }

    
    /**
     * @return the perPage
     */
    public int getPerPage() {
    
        return perPage;
    }

    
    /**
     * @param perPage the perPage to set
     */
    public void setPerPage(int perPage) {
    
        this.perPage = perPage;
    }

    
    /**
     * @return the pageTot
     */
    public int getPageTot() {
    
        return pageTot;
    }

    
    /**
     * @param pageTot the pageTot to set
     */
    public void setPageTot(int pageTot) {
    
        this.pageTot = pageTot;
    }

    
    /**
     * @return the pagePer
     */
    public int getPagePer() {
    
        return pagePer;
    }

    
    /**
     * @param pagePer the pagePer to set
     */
    public void setPagePer(int pagePer) {
    
        this.pagePer = pagePer;
    }

    
    /**
     * @return the pageMin
     */
    public int getPageMin() {
    
        return pageMin;
    }
    
    /**
     * @param pageMin the pageMin to set
     */
    public void setPageMin(int pageMin) {
    
        this.pageMin = pageMin;
    }
    
    /**
     * @return the pageMax
     */
    public int getPageMax() {
    
        return pageMax;
    }
    
    /**
     * @param pageMax the pageMax to set
     */
    public void setPageMax(int pageMax) {
    
        this.pageMax = pageMax;
    }
    
    /**
     * @return the minRows
     */
    public int getMinRows() {
    
        return minRows;
    }
    
    /**
     * @param minRows the minRows to set
     */
    public void setMinRows(int minRows) {
    
        this.minRows = minRows;
    }
    
    /**
     * @return the maxRows
     */
    public int getMaxRows() {
    
        return maxRows;
    }
    
    /**
     * @param maxRows the maxRows to set
     */
    public void setMaxRows(int maxRows) {
    
        this.maxRows = maxRows;
    }
}
