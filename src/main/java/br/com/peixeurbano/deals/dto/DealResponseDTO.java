package br.com.peixeurbano.deals.dto;

import java.time.ZonedDateTime;
import java.util.List;

public class DealResponseDTO {

    private String id;

    private String title;

    private String text;

    private ZonedDateTime createDate;

    private ZonedDateTime publishDate;

    private ZonedDateTime endDate;

    private String url;

    private Long totalSold;

    private DealType type;

    private List<BuyOptionResponseDTO> buyOptions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public ZonedDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(ZonedDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(ZonedDateTime endDate) {
        this.endDate = endDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getTotalSold() {
        return totalSold;
    }

    public void setTotalSold(Long totalSold) {
        this.totalSold = totalSold;
    }

    public DealType getType() {
        return type;
    }

    public void setType(DealType type) {
        this.type = type;
    }

    public List<BuyOptionResponseDTO> getBuyOptions() {
        return buyOptions;
    }

    public void setBuyOptions(List<BuyOptionResponseDTO> buyOptions) {
        this.buyOptions = buyOptions;
    }

    public Boolean isAvailable() {
        return this.publishDate.isBefore(ZonedDateTime.now())
                && this.endDate.isAfter(ZonedDateTime.now())
                && this.buyOptions != null
                && !this.buyOptions.isEmpty()
                && this.buyOptions.stream().anyMatch(BuyOptionResponseDTO::isAvailable);
    }

}
