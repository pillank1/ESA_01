package com.ssau.tk.esa1.ejb;


import com.ssau.tk.esa1.dao.DaoUtil;
import com.ssau.tk.esa1.dao.PlayerDao;
import com.ssau.tk.esa1.dao.HeroDao;
import com.ssau.tk.esa1.model.Hero;
import com.ssau.tk.esa1.model.Player;

import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class AppBean {

    private final HeroDao heroDao = new HeroDao();
    private final PlayerDao playerDao = new PlayerDao();

    public void createHero(Hero hero, Long playerId) {
        Player player = playerDao.get(playerId);
        if (player == null)
            return;
        hero.setPlayer(player);
        heroDao.create(hero);
    }

    public void createPlayer(Player player) {
        playerDao.create(player);
    }

    public List<Hero> getAllHeroes() {
        return heroDao.getAll();
    }

    public Hero getHeroById(Long id) {
        return heroDao.get(id);
    }

    public List<Player> getAllPlayers() {
        return playerDao.getAll();
    }

    public Player getPlayerById(Long id) {
        return playerDao.get(id);
    }

    public void updateHero(Long heroId, Hero newHeroData, Long playerId) {
        Player player = playerDao.get(playerId);
        if (player == null)
            return;
        newHeroData.setPlayer(player);
        heroDao.update(heroId, newHeroData);
    }

    public void updatePlayer(Long playerId, Player newPlayerData) {
        playerDao.update(playerId, newPlayerData);
    }

    public void deleteHero(Long heroId) {
        heroDao.delete(heroId);
    }

    public void deletePlayer(Long playerId) {
        Player player = getPlayerById(playerId);
        if (player == null)
            return;
        player.getHeroes().forEach(hero -> this.deleteHero(hero.getId()));
        DaoUtil.refresh();
        playerDao.delete(playerId);
    }
}
