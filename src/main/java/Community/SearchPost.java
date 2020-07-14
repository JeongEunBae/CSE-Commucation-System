/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Community;

import DBServer.PostSearch;
import java.util.Vector;

/**
 *
 * @author coqls
 */
public class SearchPost implements SearchInterface {

    private final int index;
    private final String keyword;

    public SearchPost(int index, String keyword) {
        this.index = index;
        this.keyword = keyword;
    }

    @Override
    public Vector search() {
        PostSearch ps = new PostSearch(index, keyword);
        return ps.informationSearch();
    }
}
